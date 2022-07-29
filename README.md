# @Lookup method injection annotation

In UserService which is a Singleton, we inject WeatherService which has Prototype scope (different objects).

Problem:
Prototype bean loses its behavior and acts like Singleton

Solution: @Lookup method injection