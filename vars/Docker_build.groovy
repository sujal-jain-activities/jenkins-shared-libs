def call(String Projectname,String Imagetag,String credentialsId){
  withCredentials([
      usernamePassword(
                        credentialsId:'${credentialsId}',
                        passwordVariable:"dockerHubPass",
                        usernameVariable:"dockerHubUser"
                        )
                        ]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker image tag ${Projectname}:${Imagetag} ${env.dockerHubUser}/${Projectname}:${Imagetag}"
                sh "docker push ${env.dockerHubUser}/${Projectname}:${Imagetag}"
                        }
                echo 'Image Uploaded to DockerHub'
}
