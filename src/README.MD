# Spring Boot with SSL Bundles and *pem* files

## Introduction
Securing your Spring Boot application just got a lot easier! 
Since Spring Boot 3.1, you can now use SSL bundles and *pem* files to secure your application.

## Set-up
* Get an SSL certificate from a trusted certificate authority (CA) like [Let's Encrypt](https://letsencrypt.org/)\
  (Let's Encrypt is free ;^P )

  * In the case of Let's Encrypt, I used their [certbot](https://certbot.eff.org/) tool to generate my SSL certificate.
  * In Windows, it puts all the certificate files into a folder named for your domain name in `C:\Certbot\live\`.
  * In a production environment, I would probably put those pem files in a vault of some sort, but Let's Encrypt manages auto-renewal of the certificates, so in order to not worry about that, I left them where they are.
  * I then used PowerShell to create a symbolic link to the `pem` files in the `src/main/resources/certs` folder.


    PS I:\git\ssl-bundle-demo\src\main\resources\certs> New-Item -ItemType SymbolicLink -Path "fullchain.pem" -Target "C:\Certbot\live\www.my-domain.whatever\fullchain.pem"

* Add the following to your application.properties/yml file


    server.port=443

    server.ssl.bundle=mybundle
    spring.ssl.bundle.pem.mybundle.keystore.certificate=classpath:certs/fullchain.pem
    spring.ssl.bundle.pem.mybundle.keystore.private-key=classpath:certs/privkey.pem 

## Call your page!
Open a browser and go to https://www.my-domain.whatever:443\
    __*Note:*__ Since I am building this demo at home, I ran into problems with NAT Loopback ([hairpinning](https://en.wikipedia.org/wiki/Network_address_translation#NAT_hairpinning)) not being permitted by my ISP. So I had to test the encryption using my phone.