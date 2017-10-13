# Spring
Master of all Spring projects


For emp :
http://localhost:8088/emp


Below is the list of urls which are of working in various ways :
URL1:
-- For all methods in this wsdl, authentication details (login and password) comes in header directly in string
http://ec2-13-126-193-205.ap-south-1.compute.amazonaws.com:8080/springAccWS/endpoints/PersonService.wsdl

URL2:
-- For  addPerson() and updatePerson() methods in this wsdl, authentication details (login and password) comes in header in a seperate header tag
-- For  deletePerson() and getPerson() methods in this wsdl, authentication details (login and password) comes in respective methods itself
http://ec2-13-126-193-205.ap-south-1.compute.amazonaws.com:8080/PersonWS/endpoints/PersonService.wsdl

URL3:
-- For all methods in this wsdl, WSS security comes in header and it has login information which is encrypted
http://ec2-13-126-193-205.ap-south-1.compute.amazonaws.com:8080/springWSSecurity/endpoints/PersonSecurityService.wsdl

Below links tell me that WSS is not yet directly supported in Salesforce, but then I am not sure. So URL3 may not work for you now. But if you know way to send WSS soap request you can try using URL3:
https://developer.salesforce.com/forums/?id=906F00000008yLzIAI
https://help.salesforce.com/articleView?id=000002522&type=1

Sample Request URL1:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:per="http://com/blog/samples/webservices/personservice">
   <soapenv:Header>
      <per:password>welcome</per:password>
      <per:login>test</per:login>
   </soapenv:Header>
   <soapenv:Body>
      <per:getPersonRequest>
         <per:id>12</per:id>
      </per:getPersonRequest>
   </soapenv:Body>
</soapenv:Envelope>
Sample Request URL2  deletePerson() :
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:per="http://com/person/webservices/personSvc">
   <soapenv:Header/>
   <soapenv:Body>
      <per:deletePersonRequest>
         <per:login>
            <per:name>?</per:name>
            <per:password>?</per:password>
         </per:login>
         <per:id>?</per:id>
      </per:deletePersonRequest>
   </soapenv:Body>
</soapenv:Envelope>

Sample Request URL2  addPerson() :
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:per="http://com/person/webservices/personSvc">
   <soapenv:Header>
      <per:header>
         <per:userid>test</per:userid>
         <per:password>welcome</per:password>
      </per:header>
   </soapenv:Header>
   <soapenv:Body>
      <per:addPersonRequest>
         <per:p>
            <per:age>45</per:age>
            <per:id>?</per:id>
            <per:name>Luis</per:name>
            <per:country>Brazil</per:country>
            <per:occupation>Footballer</per:occupation>
         </per:p>
      </per:addPersonRequest>
   </soapenv:Body>
</soapenv:Envelope>

Sample Request URL3: (WSS security)

<soapenv:Envelope xmlns:pns="http://com/anvesh/spring/wssecurity/pns" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header>
      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
         <wsse:UsernameToken wsu:Id="UsernameToken-6A29DF21FE52B307E315069239994147">
            <wsse:Username>Mickey</wsse:Username>
            <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">Mouse</wsse:Password>
            <wsse:Nonce EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary">TmWIlmj85OdlZ1LSPdEsiw==</wsse:Nonce>
            <wsu:Created>2017-10-02T05:59:59.414Z</wsu:Created>
         </wsse:UsernameToken>
      </wsse:Security>
   </soapenv:Header>
   <soapenv:Body>
      <pns:addPersonRequest>
         <pns:p>
            <pns:age>20</pns:age>
            <pns:id>?</pns:id>
            <pns:name>Ravi</pns:name>
            <pns:country>India</pns:country>
            <pns:occupation>farmer</pns:occupation>
         </pns:p>
      </pns:addPersonRequest>
   </soapenv:Body>
</soapenv:Envelope>




