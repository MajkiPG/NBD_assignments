printjson(db.ollection.updateMany( { "location.city":"Moscow" }, { $set: { "location.city": "Moskwa" } } ))