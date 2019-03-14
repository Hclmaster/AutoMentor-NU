var responses = new Vue({
    el: '#responses',
    data: {
        table_info: [],
        pattern: null
    },
    created() {
        fetch('/web/testJson.json')
            .then(response => response.json())
            .then(json => {
                this.table_info = json
            });

        alert('is it here222222?? ');
    },
    methods: {
        myMethods: function (key) {
            var key = getParams('id');
            console.log("key => ", key);
            //console.log("details => ", response.table_info);
            alert('how about this key=> ', key);
            userAction2(key);
        }
    }
});
