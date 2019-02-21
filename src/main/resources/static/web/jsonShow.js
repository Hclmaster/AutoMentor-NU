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
        },
        message2: {
            "textBlocks":[
                {
                    "label":"square.rat",
                    "text": "function overlay is not defined even though I have imported all the required packages",
                    "type":"sourceCode"
                }
            ],
            "message":"I’m getting an error when I try to use function overlay",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        }
    }
});