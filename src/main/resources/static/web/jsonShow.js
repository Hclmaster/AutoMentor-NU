var jsonObj = new Vue({
    el: '#jsonObj',
    data: {
        message: {
            "textBlocks":[
                {
                    "label":"square.rat",
                    "text": "(overlay/xy main-flag 90 90 beside my-star beside my-star beside my-star)",
                    "type":"sourceCode"
                },
                {
                    "label":"local-console",
                    "text":"overlay/xy: expects only 4 arguments, but found 11.",
                    "type":"studentOutput"
                },
                {
                    "label":"preprocessor",
                    "text":"(error* 'mcbean \"too many stars upon thars\" '(\"given\" value) 'star-bellied-sneetch'(\"stars\" value) 3)",
                    "type":"computerOutput"
                }
            ],
            "message":"I’m getting an error when I try to use overlay/xy",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        }
    }
});

//jsonObj.message = null;

/*
var responseJsonObj = new Vue({
    el: '#responsejsonObj',
    data: {
        responseMessage: {
            "textBlocks":[
                {
                    "label":"square.rat",
                    "text": "(overlay/xy main-flag 90 90 beside my-star beside my-star beside my-star)",
                    "type":"sourceCode"
                },
                {
                    "label":"local-console",
                    "text":"overlay/xy: expects only 4 arguments, but found 11.",
                    "type":"studentOutput"
                },
                {
                    "label":"preprocessor",
                    "text":"(error* 'mcbean \"too many stars upon thars\" '(\"given\" value) 'star-bellied-sneetch'(\"stars\" value) 3)",
                    "type":"computerOutput"
                }
            ],
            "message":"I’m getting an error when I try to use overlay/xy",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            },
            "response": [
                "Take a look at the examples on the pages returned by the web search with \"Racket docs beside\"",
                "Take a look at the examples at https://docs.racket-lang.org/teachpack/2htdpimage.html#%28def._%28%28lib._2htdp%2Fimage..rkt%29._beside%29%29"
            ]
        }
    }
})

responseJsonObj.responseMessage = null;*/