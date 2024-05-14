# yayawallet-java-sdk
This is a Java SDK package for handling API integration on merchant application.

# Installation
To install the sdk to your java based application, add
```
implementation 'com.github.yayawallet:yayawallet-java-sdk:VERSION'
```
to the dependencies section of your ```build.gradle``` file. You can get the list of released versions on the releases section on GitHub.

# Environment
The sdk expects api credentials to be provided by the user. To set it up, you need to create a .env file and add the following environment variables:
```
YAYA_API_URL=https://yayawallet.com/api/en
YAYA_API_PATH=/api/en
YAYA_API_KEY=your_yayawallet_api_key
YAYA_API_SECRET=your_yayawallet_api_secret
```

You can find the last two credentials on https://yayawallet.com/en/profile/settings, after you logged in to your account on a browser.

# How to use?
This sdk provides functions that will call different apis available on YaYa's system. Here is how you can call ```getTransactionListByUser``` function:
```
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Transaction;

@GetMapping("/find-by-user")
public com.yaya.sdk.Models.TransactionList getTransactionListByUser() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
    ApiClient apiClient = new ApiClient();
    Transaction transaction = new Transaction(apiClient);
    return transaction.getTransactionListByUser();
}
```

You can get the list of services available on ```com.yaya.sdk/Services package``` on this repo.