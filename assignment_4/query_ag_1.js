printjson(db.collection.aggregate( [ { $group: { _id: "$sex", averageWeight: { $avg: { $toDouble: "$weight" } }, averageHeight: { $avg: { $toDouble: "$height" } } } } ] ).toArray())