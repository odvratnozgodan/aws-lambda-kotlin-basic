# Basic AWS Lambda Function with Kotlin

This project is a basic example of writing an AWS Lambda function using Kotlin. It serves as the first in a series of projects, each increasing in complexity, to demonstrate the capabilities and features of AWS Lambda with Kotlin.

## Prerequisites

Before you begin, ensure you have the following:

- An AWS account
- AWS CLI installed and configured for your account

## Project Setup

Follow these steps to set up the project:

1. **Create the Project:**
   - Set up a new Kotlin library project. This will serve as the foundation for your Lambda function.

2. **Add Serialization Plugin:**
   - Include the Kotlin serialization plugin in your `build.gradle.kts` file:
     ```kotlin
     plugins {
         kotlin("plugin.serialization") version "2.0.21"
     }
     ```

3. **Include Dependencies:**
   - Add the necessary dependencies for serialization and AWS Lambda:
     ```kotlin
     dependencies {
         implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
         implementation("com.amazonaws:aws-lambda-java-core")
     }
     ```

4. **Create Data Classes:**
   - Define data classes for the Lambda function input and output. For this project, the input will be a class with a single variable `var message: String = ""`, and the function will echo it back in the output data class containing a single variable `val message: String`.

5. **Implement the Lambda Function:**
   - Create the `BasicLambda` class that extends the `RequestHandler` class. This class will handle the input and produce the output as defined by your data classes, thus acting as the Lambda function.

6. **Build the Fat JAR:**
   - Add the Gradle plugin for building the fat JAR:
     ```kotlin
     plugins {
         id("com.gradleup.shadow") version "8.3.5"
     }
     ```
   - Run the following Gradle task to create the library fat JAR:
     ```bash
     ./gradlew shadowJar
     ```

## Deployment

1. **Prepare the CloudFormation Template:**
   - Copy the template YAML file from the official AWS samples and modify it to suit your use case.

2. **Create an S3 Bucket:**
   - Create an S3 bucket to store the final template:
     ```bash
     aws s3 mb s3://lambda-kotlin
     ```

3. **Package the Template:**
   - Generate the final template using the AWS CLI:
     ```bash
     aws cloudformation package --template-file template.yml --s3-bucket lambda-kotlin --output-template-file template-out.yml
     ```

4. **Deploy the Template:**
   - Deploy the final template to AWS CloudFormation:
     ```bash
     aws cloudformation deploy --template-file template-out.yml --stack-name lambda-kotlin --capabilities CAPABILITY_NAMED_IAM
     ```

5. **Test the Lambda function:**
   - To test execute the following command. Note that you have to change the `YOUR_FUNCTION_NAME` to the actual name of your Lambda function(you can find it in the AWS Lambda dashboard):
     ```bash
     aws lambda invoke --function-name [YOUR_FUNCTION_NAME] --payload '{ "message": "Hey! Ho! Lets go!" }' out.json
     ```
     

## Conclusion

This project demonstrates the basic setup and deployment of an AWS Lambda function using Kotlin. As you progress through the series, you will explore more advanced features and capabilities of AWS Lambda.