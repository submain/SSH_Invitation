package controller;


import model.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.InvitationService;


@Controller
@RequestMapping("/Invitation")
@Scope("prototype")
public class InvitationController {
    @Autowired
    private InvitationService invitationService;

    /**
     * 查找全部
     * @param page
     * @param pageSiz
     * @return
     */
    @RequestMapping("/QueryInvitationOrderByTime.show")
    @ResponseBody
    public BaseResp QueryInvitationOrderByTime(String page, String pageSiz){
        System.out.println("调用了啊啊----------");
       BaseResp baseResp = null;
       try {
           baseResp = invitationService.queryAllOrderByTimeResult(page,pageSiz);
       } catch (Exception e) {
           e.printStackTrace();
       }

        System.out.println(baseResp);
       return baseResp;
   }

    /**
     * 通过关键词查找
     * @param page
     * @param pageSiz
     * @return
     */
    @RequestMapping("/QueryInvitationByKeyword.show")
    @ResponseBody
    public BaseResp QueryInvitationByKeyword(String search, String page, String pageSiz){
        BaseResp baseResp = null;
        try {
            baseResp = invitationService.queryBytitleKry(search,page,pageSiz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(baseResp);
        return baseResp;

    }
    @RequestMapping("Delete.show")
    @ResponseBody
    public BaseResp DeleteInvitation(String valid){
      int validint = Integer.parseInt(valid);
        BaseResp baseResp = null;
        try {
             baseResp = invitationService.deleteInvitation(valid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResp;
    }

















}
