# hotel-reservation

# Business requirements
- Create a simple backend application for hotel to work with reservations.
- In the application it should be possible to:
  - Create a new reservation
  - Read all of the reservations
  - Change some values of one reservation by id, which already exists

# Technical requirements
- Programming language: Java &gt;= 8 version
- Build automation tool: Gradle, Maven
- Framework: Spring, Java EE, Micronaut, MicroProfile

DB: Instead of using any DB, persist data in memory to Java Set&lt;Reservation&gt; collection, where Reservation is
Java class described in the table below:

| Field name       | Type            |
|------------------|-----------------|
| id               | Integer         |
| clientFullName   | String          |
| roomNumber       | Integer         |
| reservationDates | List<LocalDate> |

Additionally: if this task looks too easy, you can implement advanced requirements - stateful application to
store all of the changes to the file before app stops and upload state from the file when it starts.

Optionally: you can use any additional libraries or features. If you want, you can implement frontend, auth,
etc., however listed above business and technical requirements should be done.

# Technology stack
- SDK 17
- IntelliJ IDEA 2022.2.5 (Community Edition)