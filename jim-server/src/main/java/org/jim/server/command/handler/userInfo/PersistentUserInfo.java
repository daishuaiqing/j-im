package org.jim.server.command.handler.userInfo;

import org.jim.common.ImChannelContext;
import org.jim.common.config.ImConfig;
import org.jim.common.message.MessageHelper;
import org.jim.common.packets.User;
import org.jim.common.packets.UserReqBody;
import org.jim.server.config.ImServerConfig;

import java.util.Objects;

/**
 * 持久化获取用户信息处理
 */
public class PersistentUserInfo implements IUserInfo {

    @Override
    public User getUserInfo(UserReqBody userReqBody, ImChannelContext imChannelContext) {
        ImServerConfig imServerConfig = ImConfig.Global.get();
        String userId = userReqBody.getUserId();
        Integer type = userReqBody.getType();
        //消息持久化助手;
        MessageHelper messageHelper = imServerConfig.getMessageHelper();
        User user = messageHelper.getUserByType(userId, type);
        if(Objects.nonNull(user)) {
            user.setFriends(messageHelper.getAllFriendUsers(userId, type));
            user.setGroups(messageHelper.getAllGroupUsers(userId, type));
        }
        return user;
    }

}
