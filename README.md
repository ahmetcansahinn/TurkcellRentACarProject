# Rent A Car Microservices

Microservisler birbirleriyle senkron ve asenkron bağlı şekildedir.

## Keycloak ve OAuth:
Keycloak 8080 portunu kullanmaktadır.

## Discovery Server:
Spring Eureka ile aynı servis birden çok portta çalışabiliyor.
localhost:8761/

## Car Service:
Database olarak mongodb'yi kullanmaktadır. 8084 portunu kullanıyor. Cloudinary aracılığıyla resimler servise yükleniyor. 
### swagger arayüzü:
http://localhost:8085/swagger-ui/index.html#/



### Rental Service
Database olarak postgreSql'i kullanmaktadır. 8084 portunu kullanıyor.
## swagger arayüzü:
http://localhost:8084/swagger-ui/index.html#/



### Customer Service
Database olarak postgreSql'i kullanmaktadır. 8089 portunu kullanıyor.
### swagger arayüzü:
http://localhost:8089/swagger-ui/index.html#/



### Notification Service: 
Rental service ile kafka ile async olarak bağlı. Kafka zookeper ile birlikte docker üzerinde çalışmaktadır. 
Topic mesajı Nottification Service içerisinde yakalanmaktadır.

### Docker-comppse-yml dosyası bulunmaktadır.

![Untitled_Diagram drawio_1](https://github.com/ahmetcansahinn/TurkcellRentACarProject/assets/143426701/ea9343a0-cb9b-4204-a230-0c3e0a6acac8)



