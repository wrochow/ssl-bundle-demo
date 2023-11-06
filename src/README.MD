# Spring Boot with SSL Bundles and *pem* files

## Introduction
Securing your Spring Boot application just got a lot easier! 
Since Spring Boot 3.1, you can now use SSL bundles and *pem* files to secure your application.

## Set-up
* Get an SSL certificate from a trusted certificate authority (CA) like [Let's Encrypt](https://letsencrypt.org/)\
  (Let's Encrypt is free ;^P )
* Put the certificate files in a folder in your project.\
  __*Note:*__ I put mine in a folder called `certs` in the `resources` folder.
* Add the following to your application.properties/yml file


    server.port=443

    server.ssl.bundle=mybundle
    spring.ssl.bundle.pem.mybundle.keystore.certificate=classpath:certs/fullchain.pem
    spring.ssl.bundle.pem.mybundle.keystore.private-key=classpath:certs/privkey.pem 

## Call your page!
Open a browser and go to https://www.my-domain.whatever:443\
    __*Note:*__ Since I am building this demo at home, I ran into problems with NAT Loopback ([hairpinning](https://en.wikipedia.org/wiki/Network_address_translation#NAT_hairpinning)) not being permitted by my ISP. So I had to test the encryption using my phone.