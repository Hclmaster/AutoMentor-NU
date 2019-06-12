function patternMatcher(pats, obj, str) {
    var newResponses = [];
    for(var pat in pats) {
        var result = match(JSON.parse(pats[pat].pattern.request), JSON.parse(str));
        if(result.length){
            var responses = obj[pat].response;
            var accumulator = [];
            pats[pat].function = [];
            for(var id in responses) {
                var tmpResponse = responses[id];
                for(var j=0; j<result.length; j++) {
                    Object.keys(result[j]).forEach(function (key) {
                        if(result[j][key] !== 'variable') {
                            tmpResponse = tmpResponse.replace(
                                new RegExp("\\" + key, "g"), result[j][key]);
                            pats[pat].diagnosis = pats[pat].diagnosis.replace(
                                new RegExp("\\" + key, "g"), result[j][key]);
                        }
                        if(pats[pat].function.indexOf(result[j][key]) === -1){
                            pats[pat].function.push(result[j][key]);
                        }
                    })
                }
                if(!containsVar(tmpResponse)) {
                    accumulator.push([tmpResponse, pats[pat]].toString());
                }
            }
            newResponses = newResponses.concat(accumulator);
        }
    }
    print('newResponses => ', newResponses);
    return newResponses;
}

function containsVar(response) {
    var reg = new RegExp("\\?[\\w]", "g");
    if(reg.exec(response) === null) return false;
    return true;
}

function match(pat, obj, blists) {
    if (blists === undefined) blists = [{}];
    if (blists.length === 0) {
        return blists;
    } else if (isVar(pat)) {
        return bindVar(pat, obj, blists);
    } else if (typeof pat == "string") {
        return matchSubString(pat, obj, blists);
    } else if (isPrimitive(pat)) {
        return primitiveMatch(pat, obj, blists);
    } else if (Array.isArray(pat)) {
        return arrayMatch(pat, obj, blists);
    } else if (pat.and) {
        return matchAnd(pat["and"], obj, blists);
    } else if (pat.or) {
        return matchOr(pat["or"], obj, blists);
    } else if (pat.not) {
        return matchNot(pat["not"], obj, blists);
    } else if (pat.some) {
        return matchSome(pat["some"], obj, blists);
    } else if (pat.reg) {
        return regexMatch(pat, obj, blists);
    } else if (typeof pat == "object") {
        return objectMatch(pat, obj, blists);
    } else return [];
}

function matchSubString(pat, obj, blists) {
    if(typeof obj != "string") return [];
    return new RegExp(pat).exec(obj) ? blists : [];
}

function isPrimitive(x) {
    let type = (typeof x);
    return x === null || type == "undefined" ||
        type == "number" || type == "string" ||
        type == "boolean";
}

function primitiveMatch(pat, obj, blists) {
    return pat === obj ? blists : [];
}

function regexMatch(pat, obj, blists) {
    if(typeof obj != 'string') return [];

    let regExp = new RegExp(pat.reg, "g");
    print('regExp => ', regExp)
    let regResults = regExp.exec(obj);

    if(regResults === null) return [];

    let pats = pat.pats || [];
    var filtered = regResults.filter(function (el) {
        return el !== null;
    });
    return match(pats, filtered.slice(1, pats.length+1), blists);
}

function arrayMatch(pat, obj, blists) {
    if (pat.length > obj.length) {
        return [];
    }
    return matchingLoop(pat, obj, blists);
}

function objectMatch(pat, obj, blists) {
    if (isPrimitive(obj) || Array.isArray(obj) ||
        (Object.keys(pat).length > Object.keys(obj).length)) {
        return [];
    } else {
        return matchingLoop(pat, obj, blists);
    }
}

function matchingLoop(pat, obj, blists) {
    return Object.keys(pat).reduce(function (accumulator, key) {
        return match(pat[key], obj[key], accumulator);
    }, blists);
}

function matchAnd(pat, obj, blists) {
    return Object.keys(pat).reduce(function (accumulator, key) {
        return match(pat[key], obj, accumulator);
    }, blists);
}

function matchOr(pat, obj, blists) {
    return Object.keys(pat).reduce(function (accumulator, key) {
        return accumulator.concat(match(pat[key], obj, blists));
    }, []);
}

function matchNot(pat, obj, blists) {
    return blists.filter(function (blist) {
        return (!match(pat, obj, [blist]).length) ? blist : false;
    })
}

function matchSome(pat, obj, blists) {
    return Object.keys(obj).reduce(function (accumulator, key) {
        return accumulator.concat(match(pat, obj[key], blists));
    }, []);
}

function bindVar(x, val, blists) {
    return blists.reduce(function (accumulator, blist) {
        return accumulator.concat(matchVar(x, val, blist));
    }, []);
}

function matchVar(varx, val, blist) {
    if (varx in blist) {
        return isVarInBinding(varx, val, blist);
    }
    var newblist = {};
    for (var attrname in blist) {
        newblist[attrname] = blist[attrname];
    }
    newblist[varx] = val;
    return newblist;
}

function isVarInBinding(varx, val, blist) {
    if (match(blist[varx], val).length) return blist;
    else return [];
}

function isVar(x) {
    return (typeof x) === 'string' && x.startsWith('?');
}
