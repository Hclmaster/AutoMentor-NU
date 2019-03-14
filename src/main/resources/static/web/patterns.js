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
        this.myMethods();
    },
    methods: {
        myMethods () {
            var key = getParams('id');
            console.log("key => ", key);
            //console.log("details => ", response.table_info);
            userAction2(key);
        }
    }
});
