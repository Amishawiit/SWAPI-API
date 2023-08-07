1. Introduction 
This microservice aims to collect character and planet data from the SWAPI using a GET request, process this data, and store it in MongoDB. Kafka is used to facilitate communication between components and to ensure reliable data flow.
2. Architecture
The microservice consists of the following components:
•	SWAPI Data Retrieval: Fetches character and planet data from the SWAPI using GET requests.
•	Kafka Producer: Publishes fetched data as messages to Kafka topics.
•	Kafka Consumer: Listens to Kafka topics and consumes messages to store in MongoDB.
•	MongoDB: Database to store the collected data.
•	Micronaut API: Exposes endpoints to interact with the microservice, including GET and POST APIs for data retrieval and manual data addition.
3. Setup and Configuration
1.	Set up your development environment, ensuring you have Java, Gradle, Kafka, and MongoDB installed.
2.	Configure Gradle to manage dependencies and build the project.
3.	Configure Kafka producer and consumer properties.
4.	Set up MongoDB connection properties in your application configuration.
5.	Create Micronaut controllers to define API endpoints.
4. Implementation
1.	SWAPI Data Retrieval: Use Micronaut's HTTP client to make GET requests to the SWAPI endpoints for people and planets. Extract relevant data and format it.
2.	Kafka Producer: Implement a Kafka producer to send formatted SWAPI data as messages to specified Kafka topics.
3.	Kafka Consumer: Develop a Kafka consumer that listens to the Kafka topics, processes incoming messages, and stores them in MongoDB.
4.	MongoDB Integration: Use Micronaut Data MongoDB to interact with the MongoDB database. Define data models and repositories for characters and planets.
5.	Micronaut API: Create controllers to define REST endpoints for data retrieval (GET) and manual data addition (POST).
5. Usage
1.	Start Kafka and MongoDB services.
2.	Run the microservice application.
3.	Access Micronaut API endpoints through a browser or API client.
4.	Use GET endpoints to retrieve data from MongoDB.
5.	Use the POST endpoint to manually add data to MongoDB.
6. Endpoints
•	GET /api/people: Retrieve character data from MongoDB.
•	POST /api/people: Add character data manually to MongoDB.
•	Get /api/swapi/people/id : To get Character data from Swapi Api and save it in mongodb with kafka

7. Conclusion
The microservice successfully collects SWAPI data, processes it through Kafka, and stores it in MongoDB. It provides a RESTful API to interact with the collected data. Further improvements could involve enhancing error handling, implementing security measures, and optimizing Kafka message processing for increased performance.
This documentation provides an overview of the microservice's architecture, setup, implementation, and usage. Detailed code snippets and configuration details are beyond the scope of this document but can be found in your project's source code.

