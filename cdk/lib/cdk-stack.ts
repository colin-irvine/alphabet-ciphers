import { LambdaIntegration, MethodLoggingLevel, RestApi } from "aws-cdk-lib/aws-apigateway"
import { PolicyStatement } from "aws-cdk-lib/aws-iam"
import { Function, Runtime, Code } from "aws-cdk-lib/aws-lambda"
import { Stack, StackProps } from "aws-cdk-lib"
import { CfnOutput } from "@aws-cdk/core";
import { Construct } from 'constructs';

export class CdkStack extends Stack {

  private restApi: RestApi;
  private lambdaFunction: Function;
  private lambdaFunctionIntegration: LambdaIntegration;

  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    this.restApi = new RestApi(this, this.stackName + 'RestApi', {});

    this.lambdaFunction = new Function(this, this.stackName + '-lambda', {
        runtime: Runtime.JAVA_8,
        code: Code.fromAsset('./app/build/libs/app.jar'),
        handler: 'TBD',
        });
    
     this.lambdaFunctionIntegration = new LambdaIntegration(this.lambdaFunction);
     const lambdaResource = this.restApi.root.addResource(this.stackName + '-lambda');
     lambdaResource.addMethod('GET', this.lambdaFunctionIntegration);
     
  }
}
