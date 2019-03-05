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
                    "text": "(interpolate-colors blue red 0.5)",
                    "type":"sourceCode"
                },
                {
                    "label":"preprocessor",
                    "text": "blue: this variable is not defined.",
                    "type":"computerOutput"
                }
            ],
            "message":"I’m getting an error when I try to use function interpolate-colors",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message4: {
            "textBlocks":[
                {
                    "label":"square.rat",
                    "text": "(overlay/xy main-flag 90 90 beside my-star beside my-star beside my-star)",
                    "type":"sourceCode"
                },
                {
                    "label":"preprocessor",
                    "text": "overlay/xy: expects only 4 arguments, but found 11.",
                    "type":"computerOutput"
                }
            ],
            "message":"I’m getting an error when I try to use function overlay/xy",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message5:{
            "textBlocks":[
                {
                    "label":"square.rat",
                    "text":"(make-color 0 0 255 255)",
                    "type":"sourceCode"
                },
                {
                    "label":"preprocessor",
                    "text":"function call: expected a function after open parenthesis, but received (make-color 0 0 255 255) and highlighted \\\"color1\\\"",
                    "type":"computerOutput"
                }
            ],
            "message": "I'm getting error when I worte (make-color 0 0 255 255), and I'm not sure where this is coming from, and the section racket highlights is \\\"color1\\\"",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message6:{
            "textBlocks":[
                {
                    "label":"preprocessor",
                    "text": "Iterated-overlay not defined.",
                    "type": "computerOutput"
                }
            ],
            "message": "I'm getting error using Iterated-overlay function.",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message7:{
            "textBlocks":[
                {
                    "label": "swatch.rat",
                    "text": "(make-color 0 0 255 255)",
                    "type": "sourceCode"
                },
                {
                    "label": "preprocessor",
                    "text": "function call: expected a function after the open parenthesis, but received (make-color 0 0 255 255).",
                    "type": "computerOutput"
                }
            ],
            "message": "When run the code for the swatch with the check-expects, it gives me this error, highlighting the 'color1' portion after the interpolate-colors procedure.",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message8:{
            "textBlocks":[
                {
                    "label": "preprocessor",
                    "text": "iterated-beside: expects procedure, given #<image>",
                    "type": "computerOutput"
                }
            ],
            "message": "Able to define swatch, but when I go to call swatch I get an error.",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message9:{
            "textBlocks":[
                {
                    "label": "preprocessor",
                    "text": "string=?: expects a string as 2nd argument, given (make-album \\\"Highspeeds\\\" \\\"Elliot Moss\\\" \\\"Alt Rock\\\")",
                    "type": "computerOutput"
                }
            ],
            "message": "I'm getting an error when using function string=?. What could be causing the error?",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message10:{
            "textBlocks":[
                {
                    "label": "preprocessor",
                    "text": "overlay: expects an image as first argument, given (lambda (a1) ...)",
                    "type": "computerOutput"
                }
            ],
            "message": "overlay in my-iterated-overlay is throwing this error from the check-expect. Why can a lambda not start the overlay function.",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message11:{
            "textBlocks":[
                {
                    "label": "branch.rat",
                    "text": "(define (sum-tree tree) (local [(define (loop tree count)" +
                        "(if (leaf? tree) (leaf-val tree)" +
                        "(+(loop (branch-left tree) count)" +
                        "(loop (branch-right tree) count))))" +
                        "(define (loop_2 tree count_2)" +
                        "(if (branch? tree)" +
                        "(+(loop_2 (branch-left tree) count_2)" +
                        "(loop_2 (branch-right tree) count_2))(branch-val tree)))]" +
                        "(+(loop tree 0) (loop_2 tree 0) (branch-val tree))))",
                    "type": "sourceCode"
                },
                {
                    "label": "preprocessor",
                    "text": "branch-val: expects a branch, given (make-leaf 1).",
                    "type": "computerOutput"
                }
            ],
            "message": "Difficulty Looping through Branches. The issue is that I get an error of: branch-val: expects a branch, given (make-leaf 1).",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        },
        message12:{
            "textBlocks":[
                {
                    "label": "preprocessor",
                    "text": "+: expects a number as 1st argument, given leaf-val",
                    "type": "computerOutput"
                }
            ],
            "message": "When I try to run my sum-tree function, I get this error message.",
            "student":{
                "name": "Cathy",
                "id": "clj8621"
            }
        }
    }
});