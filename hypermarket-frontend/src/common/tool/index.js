import { Message, Notification } from "element-ui";
/**
 * 消息提示
 * @author Jack
 * @param customMessage 内容
 * @param messageType 类型
 */
export default function(customMessage, messageType = "info") {
  Message({
    showClose: false,
    message: customMessage,
    type: messageType,
    duration: 2000,
    customClass: "custom-class"
  });
}
/**
 * 消息提示
 * @author Jack
 * @param title 标题
 * @param customMessage 内容
 * @param noticeType 类型
 */
export const Notice = function(title, customMessage, noticeType = "info") {
  Notification({
    title: title,
    message: customMessage,
    type: noticeType,
    duration: 2000
  });
};
