import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import GetImage from "./components/GetImage";
import UploadImage from "./components/UploadImage";

function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route exact path="/" component={UploadImage} />
          <Route exact path="/images" component={GetImage} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
