import Vue from "vue";
import {
  Button,
  Form,
  FormItem,
  Input,
  InputNumber,
  Checkbox,
  Card,
  Carousel,
  CarouselItem,
  Breadcrumb,
  BreadcrumbItem,
  MessageBox
} from "element-ui";

Vue.use(Button);
Vue.use(Form);
Vue.use(FormItem);
Vue.use(Input);
Vue.use(InputNumber);
Vue.use(Checkbox);
Vue.use(Card);
Vue.use(Carousel);
Vue.use(CarouselItem);
Vue.use(Breadcrumb);
Vue.use(BreadcrumbItem);

Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$confirm = MessageBox.confirm;
