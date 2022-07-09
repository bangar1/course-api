package topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topicList = new ArrayList<Topic>(Arrays.asList(
            new Topic("Spring", "Spring Framework", "Let Spring manage your Project"),
            new Topic("Java", "Java 8", "Let Spring manage your Project")));

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        return topicList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic, String id) {
        for(Topic sourceTopic : topicList){
            if(sourceTopic.getId().equals(id)){
                topicList.set(topicList.indexOf(sourceTopic), topic);
            }
        }
        return topic;
    }
}
