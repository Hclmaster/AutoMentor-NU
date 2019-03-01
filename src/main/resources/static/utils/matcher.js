function stringMatch(pat, obj) {
    return match(JSON.parse(pat), JSON.parse(obj));
}

function match(pat, obj, blists) {
    if (blists == undefined) blists = [{}];
    if (blists.length == 0) {
        return blists;
    } else if (isVar(pat)) {
        return matchItem(pat, obj, blists);
    } else if (typeof pat == "string" && typeof obj == "string") {
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
    } else if (pat.contains) {
        return matchContains(pat["contains"], obj, blists);
    } else if (pat.reg) {
        return regexMatch(pat["reg"], obj, blists);
    } else if (typeof pat == "object" &&
        !(Array.isArray(pat) || Array.isArray(obj))) {
        return objectMatch(pat, obj, blists);
    } else return [];
}

function matchSubString(pat, obj, blists) {
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
    var regExp = new RegExp(pat, "g");
    var current, ans = [];
    while (current = regExp.exec(obj)) {
        ans.push(current);
    }
    return ans;
}

function arrayMatch(pat, obj, blists) {
    if (pat.length > obj.length) {
        return [];
    }
    return matchingLoop(pat, obj, blists);
}

function objectMatch(pat, obj, blists) {
    if (isPrimitive(obj) ||
        (Object.keys(pat).length > Object.keys(obj).length)) {
        return [];
    } else {
        return matchingLoop(pat, obj, blists);
    }
}

function matchAnd(pat, obj, blists) {
    if (pat.hasOwnProperty("and") ||
        pat.hasOwnProperty("or") ||
        pat.hasOwnProperty("not") ||
        pat.hasOwnProperty("some") ||
        pat.hasOwnProperty("contains")) {
        return match(pat, obj, blists);
    } else {
        return andMatchingLoop(pat, obj, blists);
    }
}

function matchOr(pat, obj, blists) {
    if (pat.hasOwnProperty("and") ||
        pat.hasOwnProperty("or") ||
        pat.hasOwnProperty("not") ||
        pat.hasOwnProperty("some") ||
        pat.hasOwnProperty("contains")) {
        return match(pat, obj, blists);
    } else {
        return orMatchingLoop(pat, obj, blists);
    }
}

function matchNot(pat, obj, blists) {
    if (pat.hasOwnProperty("and") ||
        pat.hasOwnProperty("or") ||
        pat.hasOwnProperty("not") ||
        pat.hasOwnProperty("some") ||
        pat.hasOwnProperty("contains")) {
        return match(pat, obj, blists).length ? [] : blists;
    } else {
        return notMatchingLoop(pat, obj, blists);
    }
}

function matchSome(pat, obj, blists) {
    var ans = Object.keys(obj).reduce(function (accumulator, key) {
        return accumulator.concat(match(pat, obj[key], blists));
    }, []);
    ans = removeDuplicates(ans, JSON.stringify);
    if (ans.length > 1) {
        return ans.filter(value => Object.keys(value).length !== 0);
    } else return ans;
}

function matchContains(pat, obj, blists) {
    var ans = Object.keys(pat).reduce(function (accumulator, key) {
        if (isPrimitive(obj)) {
            return match(pat[key], obj, accumulator);
        } else {
            return iterateObjLoop(pat[key], obj, accumulator);
        }
    }, blists);
    ans = removeDuplicates(ans, JSON.stringify);
    if (ans.length > 1) {
        return ans.filter(value => Object.keys(value).length !== 0);
    } else return ans;
}

function andMatchingLoop(pat, obj, blists) {
    return Object.keys(pat).reduce(function (accumulator, key) {
        return match(pat[key], obj, accumulator);
    }, blists);
}

function orMatchingLoop(pat, obj, blists) {
    var ans = Object.keys(pat).reduce(function (accumulator, key) {
        return accumulator.concat(match(pat[key], obj, blists));
    }, []);
    ans = removeDuplicates(ans, JSON.stringify);
    if (ans.length > 1) {
        return ans.filter(value => Object.keys(value).length !== 0);
    } else return ans;
}

function removeDuplicates(arr, key) {
    var seen = new Set();
    return arr.filter(function (item) {
        var k = key(item);
        return seen.has(k) ? false : seen.add(k);
    })
}

function notMatchingLoop(pat, obj, blists) {
    return blists.filter(function (blist) {
        return (!match(pat, obj, [blist]).length) ? blist : false;
    })
}

function iterateObjLoop(pat, obj, blists) {
    return Object.keys(obj).reduce(function (accumulator, key) {
        return accumulator.concat(match(pat, obj[key], blists));
    }, []);
}

function matchingLoop(pat, obj, blists) {
    return Object.keys(pat).reduce(function (accumulator, key) {
        return match(pat[key], obj[key], accumulator);
    }, blists);
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