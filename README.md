# BAV
Business Account Validation

This program acts as a middle-man for the BAV api provided by bank <X>.  For the user, it supports the __/account/verification__ with the API spec published at [SWIFT Swaggerhub](https://www.swaggerhub.com)
  
To process the request, it forms a new request in the format required by bank <X>, get's the response and reformats it as per the SWIFT BAV spec.
