# chucknorris.io API client for Kotlin

Kotlin client for [chucknorris.io](https://api.chucknorris.io)  API.

## Usage

```kotlin

// create api client
val client = ChuckNorrisClientFactory.chuckNorrisIOClient()

// get all categories
val categories = client.categories

// print 5 random jokes
    repeat(5) {
        println(client.randomJoke())
    }
//  search for java jokes
  val javaJokes = client.searchJokes("java")

```
