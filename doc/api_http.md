# API HTTP

## Créer un bid sur un marché
```
POST /markets/{marketId}/bids

Request:
{
    "blocks": [
        {
            "instantInterval": {
                "start": "2021-12-21T00:00:00Z", #ISO8601
                "end": "2021-12-22T00:00:00Z"
            },
            "price": 1.0, # Currency per megawatt
            "supplies": [
                {
                    "supplierId": "supplier_1",
                    "energy": 1.0 # megawatt
                }
            ]
        }
    ]
}

Response:
{
    "marketId": "market_1",
    "blocks": [
        {
            "instantInterval": {
                "start": "2021-12-21T00:00:00Z", #ISO8601
                "end": "2021-12-22T00:00:00Z"
            },
            "price": 1.0, # Currency per megawatt
            "supplies": [
                {
                    "supplierId": "supplier_1",
                    "energy": 1.0 # megawatt
                }
            ]
        }
    ]
}
```

## Lister les bids d'un marché
```
GET /markets/{marketId}/bids

Response:
{
    "items": [
        {
            "marketId": "market_1",
            "blocks": [
                {
                    "instantInterval": {
                        "start": "2021-12-21T00:00:00Z", #ISO8601
                        "end": "2021-12-22T00:00:00Z"
                    },
                    "price": 1.0, # Currency per megawatt
                    "supplies": [
                        {
                            "supplierId": "supplier_1",
                            "energy": 1.0 # megawatt
                        }
                    ]
                }
            ]
        }
    ]
}
```

## Lister les fournisseurs participant à au moins un bid sur un marché
```
GET /markets/{marketId}/suppliers

Response:
{
    "items": [
        "supplier_1"
    ]
}
```
