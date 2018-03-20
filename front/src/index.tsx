import * as React from 'react';
import * as ReactDOM from 'react-dom';
import Home from "./containers/home/home";

class App extends React.Component {

    constructor(props: P, context: any) {
        super(props, context);
    }

    public render() {
        return (
            <div>
                <Home/>
            </div>
        );
    }
}

ReactDOM.render(<App/>, document.getElementById("app"))