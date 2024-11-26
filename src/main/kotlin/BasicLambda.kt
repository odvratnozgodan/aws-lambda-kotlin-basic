package solutions.deliverit

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.RequestHandler
import solutions.deliverit.models.RequestInput
import solutions.deliverit.models.ResponseOutput


class BasicLambda : RequestHandler<RequestInput, ResponseOutput> {
    override fun handleRequest(
        request: RequestInput?,
        context: Context
    ): ResponseOutput {
        val logger: LambdaLogger = context.logger
        logger.log("ECHO INPUT RECEIVED: " + request?.message)
        return when (request) {
            null -> ResponseOutput("No input provided.")
            else -> ResponseOutput("Received message: ${request.message}")
        }
    }
}