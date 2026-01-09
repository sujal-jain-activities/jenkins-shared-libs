def call(String url, String branch){
  echo "Code started"
  git url: "${url}" , branch: "${branch}"
  echo "Code Ended"
}
