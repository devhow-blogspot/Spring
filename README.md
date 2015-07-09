
This project is a Spring MVC application fully  configured with annotations instead of XML files. The data access layer is
using Spring Data JPA. The database layer is also configured with configuration class and there is no XML which setup the
datasource, the session factory, the transaction manager,.... All those beans are configured programatically.

Since Spring 3.0+, @Configuration is an alternative to XML configurations.
