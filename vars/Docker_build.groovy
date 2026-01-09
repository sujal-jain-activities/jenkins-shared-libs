def call(String Projectname,String Imagetag,String CredentialsId){
  withCredentials([
      usernamePassword(
                        credentialsId:'${CredentialsId}',
                        passwordVariable:"dockerHubPass",
                        usernameVariable:"dockerHubUser"
                        )
                        ]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                        }
                sh "docker image tag ${Projectname}:${Imagetag} ${env.dockerHubUser}/${Projectname}:${Imagetag}"
                sh "docker push ${env.dockerHubUser}/${Projectname}:${Imagetag}"
                echo 'Image Uploaded to DockerHub'
}
