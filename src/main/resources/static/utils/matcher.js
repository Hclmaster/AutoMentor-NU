function stringMatch(pat, obj) {
    return match(JSON.parse(pat), JSON.parse(obj));
}

function match(pat, obj, blists = [{}]) {
    if (blists.length == 0) {
        return blists;
    } else if (isVar(pat)) {
        return matchItem(pat, obj, blists);
    } else if (typeof pat == "string" && typeof obj == "string") {
        return matchSubString(pat, obj, blists);
    } else if (isPrimitive(pat) && isPrimitive(obj)) {
        return primitiveMatch(pat, obj, blists);
    } else if (Array.isArray(pat) && Array.isArray(obj)) {
        return arrayMatch(pat, obj, blists);
    } else if (pat && (typeof pat == "object") && ("and" in pat)) {
        return matchAnd(pat["and"], obj, blists);
    } else if (pat && (typeof pat == "object") && ("or" in pat)) {
        return matchOr(pat["or"], obj, blists);
    } else if (pat && (typeof pat == "object") && ("not" in pat)) {
        return matchNot(pat["not"], obj, blists);
    } else if (pat && (typeof pat == "object") && ("some" in pat)) {
        return matchSome(pat["some"], obj, blists);
    } else if (pat && (typeof pat == "object") && ("contains" in pat)) {
        return matchContains(pat["contains"], obj, blists);
    } else if (pat && (typeof pat == "object") && ("reg" in pat)) {
        return regexMatch(pat["reg"], obj, blists);
    } else if (typeof pat == "object" && typeof obj == "object"
        && !(Array.isArray(pat) || Array.isArray(obj))) {
        return objectMatch(pat, obj, blists);
    } else return [];
}

function matchSubString(pat, obj, blists) {
    return new RegExp(pat).exec(obj) ? blists : [];
}

function isPrimitive(x) {
    let type = (typeof x);
    return type == "number" || type == "string" || type == "boolean";
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
    if (pat == null && obj == null) return blists;
    else if ((pat == null && obj) || (obj == null && pat)
        || (Object.keys(pat).length > Object.keys(obj).length)) {
        return [];
    } else {
        return matchingLoop(pat, obj, blists);
    }
}

function matchAnd(pat, obj, blists) {
    if (pat && (pat.hasOwnProperty("and") || pat.hasOwnProperty("or")
        || pat.hasOwnProperty("not") || pat.hasOwnProperty("some")
        || pat.hasOwnProperty("contains"))) {
        return match(pat, obj, blists);
    } else {
        return andMatchingLoop(pat, obj, blists);
    }
}

function matchOr(pat, obj, blists) {
    if (pat && (pat.hasOwnProperty("and") || pat.hasOwnProperty("or")
        || pat.hasOwnProperty("not") || pat.hasOwnProperty("some")
        || pat.hasOwnProperty("contains"))) {
        return match(pat, obj, blists);
    } else {
        return orMatchingLoop(pat, obj, blists);
    }
}

function matchNot(pat, obj, blists) {
    if (pat && (pat.hasOwnProperty("and") || pat.hasOwnProperty("or")
        || pat.hasOwnProperty("not") || pat.hasOwnProperty("some")
        || pat.hasOwnProperty("contains"))) {
        return match(pat, obj, blists).length ? [] : blists;
    } else {
        return notMatchingLoop(pat, obj, blists);
    }
}

function matchSome(pat, obj, blists) {
    return someMatchingLoop(pat, obj, blists);
}

function matchContains(pat, obj, blists) {
    return containsMatchingLoop(pat, obj, blists);
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
    return blists.reduce(function (accumulator, blist) {
        if (!match(pat, obj, [blist]).length) {
            return accumulator.concat(blist);
        } else return accumulator;
    }, []);
}

function someMatchingLoop(pat, obj, blists) {
    var ans = Object.keys(obj).reduce(function (accumulator, key) {
        return accumulator.concat(match(pat, obj[key], blists));
    }, []);
    ans = removeDuplicates(ans, JSON.stringify);
    if (ans.length > 1) {
        return ans.filter(value => Object.keys(value).length !== 0);
    } else return ans;
}

function containsMatchingLoop(pat, obj, blists) {
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
    for (var attrname in blist) { newblist[attrname] = blist[attrname]; }
    newblist[x] = val;
    return newblist;
}

function isVar(x) {
    return (typeof x) == "string" && x.startsWith('?');
}