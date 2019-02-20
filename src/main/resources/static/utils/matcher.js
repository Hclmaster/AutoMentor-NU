function stringMatch(pat, obj) {
    return match(JSON.parse(pat), JSON.parse(obj));
}

function match(pat, obj, blists = [{}]) {
    if (blists.length == 0) {
        return blists;
    } else if (isVar(pat)) {
        return matchItem(pat, obj, blists);
    } else if (isPrimitive(pat) && isPrimitive(obj)) {
        return primitiveMatch(pat, obj, blists);
    } else if (Array.isArray(pat) && Array.isArray(obj)) {
        return arrayMatch(pat, obj, blists);
    } else if (typeof pat == "object" && typeof obj == "object") {
        return objectMatch(pat, obj, blists);
    } else return [];
}

function isPrimitive(x) {
    let type = (typeof x);
    return type == "number" || type == "string" || type == "boolean";
}

function primitiveMatch(pat, obj, blists) {
    return pat === obj ? blists : [];
}

function arrayMatch(pat, obj, blists) {
    if (pat.length != obj.length) {
        return [];
    }
    return matchingLoop(pat, obj, blists);
}

function objectMatch(pat, obj, blists) {
    if (Object.keys(pat).length != Object.keys(obj).length) {
        return [];
    } else {
        return matchingLoop(pat, obj, blists);
    }
}

function matchingLoop(pat, obj, blists) {
    Object.keys(pat).forEach((key) => {
        blists = match(pat[key], obj[key], blists);
    });
    return blists;
}

function matchItem(x, val, blists) {
    return blists.reduce(function (accumulator, blist) {
        return accumulator.concat(matchVar(x, val, blist));
    }, []);
}

function matchVar(x, val, blist) {
    if (blist.hasOwnProperty(x)) {
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