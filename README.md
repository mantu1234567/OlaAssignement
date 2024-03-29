# OlaAssignement
Create Shipmet
@RequestMapping("/ola)
@PostMapping("/shipment") -> this take a request Body call Shipment
Shipment Structure in JSON
{
"senderName":"Mantu Kumar",
"senderAddress":"Patna",
"recipientName":"Munna kumar",
"recipientAddress":"Delhi",
"currentLocation" : "Bhopal",
"packageDetails": {
    "dimensions": {
    "length": 10,
    "width": 7,
    "height": 10
    }
  }
}
Update Shipment
@PatchMapping("/{shipmentId})

take one path variable and RequestBody ShipmentUpdate

Shipment body look like this in JSON format

 {
 "status":"Dispatch",
 "currentLocation":"Patna"
 }
Screenshot (310)

Tracking Shipment
@PostMapping("/track/{trackingId})
take only one path variable Screenshot (311)
Buy Shipment
@PostMapping("{shipmentId}/buy)
take only one path variable Screenshot (312)
Quote
@PostMapping("/quote)
that take on requestBody call quote Request
Quote request look like this in JSON format
{
   "origin":"Kajra , India,Bihar",
   "destination":"Delhi ,India",
    "packageDetails": {
     "dimensions": {
     "length": 10,
     "width": 5,
     "height": 8
     }
   }
}
Screenshot (309)

Scheduled Pickup
PostMapping("/pickup)
take one RequestBody call PickupRequest
PickupRequest looks like this in JSON format
{   
 "shipmentId": 3,
 "pickupDate": "2024-03-31T15:00:00",
 "location": "Bhopal Sundarnagar",
 "specialInstructions": "Leave package at the back door."
}
Screenshot (313)

Register user
@RequestMapping("user")

PostMapping("/register)
take one requestBody call user
User in JSON format
{
 "username": "Mantu",
"password": "Mantu123",
"email": "mk@gamil.com",
"role": "CUSTOMER"
}
Screenshot (314)

Login User
PostMapping("/login)
take RequsetBody call LoginRequest
LoginRequest in JSON format
{
 "email": "mk@gamil.com",
 "password": "password12"
 }
Screenshot (315)
