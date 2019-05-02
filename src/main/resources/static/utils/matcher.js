function stringMatch(pat, obj, responses) {
    var result = match(JSON.parse(pat), JSON.parse(obj));
    //print('result => ', result.length);
    if (responses == null && result.length != 0) return [{}];
    else if(result.length == 0) return [];
    var newReponses = [];

    for(var i=0; i<responses.length; i++){
        var response = responses[i];
        for(var j=0; j<result.length; j++){
            Object.keys(result[j]).forEach(function (key) {
                response = response.replace(new RegExp("\\"+key, "g"), result[j][key]);
            })
        }
        newReponses[i] = response;
    }
    return newReponses;
}

function match(pat, obj, blists) {
    if (blists == undefined) blists = [{}];
    if (blists.length == 0) {
        return blists;
    } else if (isVar(pat)) {
        return matchItem(pat, obj, blists);
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
    return x == null || type == "undefined" ||
        type == "number" || type == "string" ||
        type == "boolean";
}

function primitiveMatch(pat, obj, blists) {
    return pat === obj ? blists : [];
}

function regexMatch(pat, obj, blists) {
    if(typeof obj != 'string') return [];

    let regExp = new RegExp(pat.reg, "g");
    let regResults = regExp.exec(obj);

    if(regResults == null) return [];

    let pats = pat.pats || [];
    var filtered = regResults.filter(function (el) {
        return el != null;
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

function matchItem(x, val, blists) {
    return blists.reduce(function (accumulator, blist) {
        return accumulator.concat(matchVar(x, val, blist));
    }, []);
}

function matchVar(x, val, blist) {
    if (x in blist) {
        if (match(blist[x], val).length) return blist;
        else return [];
    }
    var newblist = {};
    for (var attrname in blist) {
        newblist[attrname] = blist[attrname];
    }
    newblist[x] = val;
    return newblist;
}

function isVar(x) {
    return (typeof x) == "string" && x.startsWith('?');
}