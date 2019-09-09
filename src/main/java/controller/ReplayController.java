package controller;

import model.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ReplayService;

import java.util.Date;

@Controller
@RequestMapping("/Replay")
@Scope("prototype")
public class ReplayController {
    @Autowired
    private ReplayService replayServiceImpl;

    /**
     * 添加回复
     * @param name
     * @param content
     * @param valid
     * @return
     */
    @RequestMapping("/AddReplay.show")
    @ResponseBody
    public BaseResp addReplay(String name, String content, String valid){
        BaseResp baseResp = null;
        int validint = Integer.parseInt(valid);
        try {
             baseResp = replayServiceImpl.addReplayResult(content,name,new Date(),validint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResp;
    }

    /**
     * 通过帖子ID查找回复
     * @param valid
     * @return
     */
    @RequestMapping("/QueyReplayByValid.show")
    @ResponseBody
    public BaseResp queyReplayByValid(String valid){
      int validint = Integer.parseInt(valid);
      BaseResp baseResp = null;
        try {
            baseResp = replayServiceImpl.queryReplayByTitleIdResult(validint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResp;
    }

}
