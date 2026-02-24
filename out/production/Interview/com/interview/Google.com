1. You type www.google.com into the address bar of your browser.

2. The browser checks the cache for a DNS record to find the corresponding IP address of www.google.com

DNS(Domain Name System) is a database that maintains the name of the website (URL) and the particular IP addresses for
that website. Every single URL on the internet has a unique IP address assigned to it. The IP address belongs to the
computer which hosts the server of the website we are requesting to access. For example, www.google.com has an IP
address of 209.85.227.104. So if you’d like, you can reach www.google.com by typing http://209.85.227.104 on your
browser. DNS is a list of URLs, and their IP addresses, like how a phone book.

The primary purpose of DNS is human-friendly navigation. You can easily access a website by typing the correct IP
address for it on your browser, but imagine having to remember different sets of numbers for all the sites we regularly
access? Therefore, it is easier to remember the name of the website using a URL and let DNS do the work for us by
mapping it to the correct IP.

To find the DNS record, the browser checks four caches.

    ● First, it checks the browser cache.
    ● Second, the browser checks the OS cache.
    ● Third, it checks the router cache.
    ● Fourth, it checks the ISP(Internet Service Provider) cache.


3. ISP’s DNS server initiates a DNS query to find the IP address of the server that hosts www.google.com.

As mentioned earlier, for my computer to connect with the server that hosts www.google.com, I need the IP address of
www.google.com. The purpose of a DNS query is to search multiple DNS servers on the internet until it finds the correct
IP address for the website. This type of search is called a recursive search since the search will repeatedly continue
from a DNS server to a DNS server until it either finds the IP address we need or returns an error response saying it
was unable to find it.

For www.google.com, first, the DNS server will contact the root name server. The root name server will redirect it to
the .com domain name server. .com name server will redirect it to the google.com name server. The google.com name
server will find the matching IP address for www.google.com in its’ DNS records and return it to your DNS server,
which will send it back to your browser.


4. The browser initiates a TCP connection with the server.

Once the browser receives the correct IP address, it will build a connection with the server that matches the IP address
to transfer information. Browsers use internet protocols to build such connections. There are several different
internet protocols that can be used, but TCP is the most common protocol used for many types of HTTP requests.

To transfer data packets between your computer and the server, it is important to have a TCP connection established.
This connection is established using a process called the TCP/IP three-way handshake. This is a three-step process
where the client and the server exchange SYN(synchronize) and ACK(acknowledge) messages to establish a connection.

    a. The client machine sends a SYN packet to the server over the internet, asking if it is open for new connections.

    b. If the server has open ports that can accept and initiate new connections, it’ll respond with an ACKnowledgment
    of the SYN packet using a SYN/ACK packet.

    c. The client will receive the SYN/ACK packet from the server and will acknowledge it by sending an ACK packet.

Then a TCP connection is established for data transmission!


5. The browser sends an HTTP request to the webserver.

Once the TCP connection is established, it is time to start transferring data! The browser will send a GET request
asking for www.google.com web page. This request will also contain additional information like headers, request type,
cookies etc.


6. The server handles the request and sends back a response.

The server receives the request from the browser and passes it to a request handler to read and generate a response.
The request handler is a program that reads the request, it’s headers, and cookies to check what is being requested
and also update the information on the server if needed. Then it will assemble a response in a particular format
(JSON, XML, HTML).


7. The server sends out an HTTP response.

The server response contains the web page you requested as well as the status code, compression type (Content-Encoding),
how to cache the page (Cache-Control), any cookies to set, privacy information, etc.


8. The browser displays the HTML response

The browser displays the HTML content in phases. First, it will render the bare bone HTML skeleton. Then it will check
the HTML tags and send out GET requests for additional elements on the web page, such as images, CSS stylesheets,
JavaScript files, etc. These static files are cached by the browser, so it doesn’t have to fetch them again the next
time you visit the page. In the end, you’ll see www.google.com appearing on your browser.