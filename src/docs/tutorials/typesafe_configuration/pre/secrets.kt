package tutorials.typesafe_configuration.pre

import java.nio.ByteBuffer
import org.http4k.client.OkHttp
import org.http4k.core.Method.GET
import org.http4k.core.Request

val s3 = OkHttp()

fun readFile(secretKey: String, bucketKey: String): ByteBuffer {
    return s3(Request(GET, "https://mybucket.s3.amazonaws.com/$bucketKey")).body.payload
}

// export AWS_SECRET_KEY=someSuperSecretValueThatOpsReallyDoNotWantYouToKnow

val file = readFile(System.getenv("AWS_SECRET_KEY"), "myfile.txt")
