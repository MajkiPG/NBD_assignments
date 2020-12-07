var map = function() {
    emit(this.job, null);
};

var reduce = function() {
    return null;
}

var options = { out: "UniqueJobs" };

db.collection.mapReduce(map, reduce, options)
printjson(db.UniqueJobs.find({}, {id:1}).toArray()) 