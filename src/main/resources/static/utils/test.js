function avg(input, period) {
    var output = [];
    if (input === undefined) {
        return output;
    }
    var i,j=0;
    for (i = 0; i < input.length- period; i++) {
        var sum =0;
        for (j = 0; j < period; j++) {
            //print (i+j)
            sum =sum + input[i+j];
        }
        //print (sum + " -- " + sum/period)
        output[i]=sum/period;
    }

    for(i = 0; i < output.length; i++){
        print("output[i] = ", output[i])
    }

    return output;
}