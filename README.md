# repository-design-pattern

The Benefits of using repository design pattern is to for search or delete using a specific criteria or specification.

Creating Repository

1 – Creating Repository Interface, I’m using generic type so I can use the same interface to create different repositories to hold different objects.

2 - Creating a specification interface, also using generic type so I can use the same specification to create different specification objects

3 - I’m using singleton as storage just to work as it is a database table where you have only one instance table in the whole program.

4 – The implementation of the specification is using Boolean flag so we can use it later in the repository for the search or delete purposes, 
