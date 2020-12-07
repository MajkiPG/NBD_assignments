var map = function() {
    emit(this.nationality, { weights: [this.weight], heights: [this.height], count: 0 });
}

var reduce = function(key, value) {
    reducedValue = { weights: [], heights: [], count: value.length };
    for(var i = 0; i < value.length; i++) {
        reducedValue.weights.push(parseFloat(value[i].weights[0]));
        reducedValue.heights.push(parseFloat(value[i].heights[0]));
    }
    return reducedValue;
}

function finalize(key, value) {
    var sum = 0;
    var min = 1000000.0;
    var max = 0;
    for (var i = 0; i < value.count; i++) {
        var tmpBmi = value.weights[i] / Math.pow((value.heights[i]/100), 2);
        sum += tmpBmi;
        min = tmpBmi < min ? tmpBmi : min;
        max = tmpBmi > max ? tmpBmi : max;
    }
    return { averageBmi: sum/value.count, minBmi: min, maxBmi: max };
}

var options = { out: "BmiMinMaxAverage", finalize: finalize };

db.collection.mapReduce(map, reduce, options);
printjson(db.bmi.find().toArray());