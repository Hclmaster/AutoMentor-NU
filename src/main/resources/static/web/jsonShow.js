var jsonObj = new Vue({
    el: '#jsonObj',
    data: {
        message1: {
            "textBlocks":[
                {
                    "label":"square.rat",
                    "text": "(beside (a-red-square) (a-blue-square) (a-green-square))",
                    "type":"sourceCode"
                },
                {
                    "label":"preprocessor",
                    "text":"function call: expected a function after the open parenthesis, but received #<image>.",
                    "type":"computerOutput"
                }
            ],
            "message":"I'm getting an error using function beside",
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
        },
        message3: {
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