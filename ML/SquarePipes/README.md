docker run -it -p 8080:8080 -v $(pwd)/mydata:/label-studio/data heartexlabs/label-studio:latest

docker run -it -p 8080:8080 \
  -v $(pwd)/mydata:/label-studio/data \
  -v /home/kepler/images:/images \
  -e LOCAL_FILES_SERVING_ENABLED=true \
  heartexlabs/label-studio:latest
  
<View>
  <Image name="image" value="$image"/>
  <RectangleLabels name="tag" toName="image">
    <Label value="truba" background="red"/>
  </RectangleLabels>
</View>