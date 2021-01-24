from riak import RiakClient

def retrieve_doc(key):
	doc = bucket.get(key)
	if doc.exists:
		print(doc.encoded_data)
		return doc
	print("document not found")

client  =  RiakClient(protocol="http", host="localhost", http_port=8098)
bucket = client.bucket("s21999")

document = {"team_name": "Mercedes-AMG Petronas Formula One Team", "championship_points": 573, "color": "black", "driver1": "Lewis Hamilton"}
mercedes = bucket.new("mercedes", data=document)
mercedes.store()

mercedes = retrieve_doc("mercedes")

mercedes.data["driver1"] = "George Russel"
mercedes.store()

mercedes = retrieve_doc("mercedes")

mercedes.delete()

mercedes = retrieve_doc("mercedes")

