import * as React from 'react';
import axios from 'axios';
import {fromPromise} from "rxjs/observable/fromPromise";

class Home extends React.Component {

    constructor(props: P, context: any) {
        super(props, context);
        this.state = {data: []}
    }

    public render() {
        return (
            <div>
                <ul>
                    {this.state.data.map(emps => {
                        return (<li>{emps.emp_no}</li>)
                    })}
                </ul>
            </div>
        );
    }

    public componentDidMount() {
        fromPromise(axios.get("http://server.gman.io/employees"))
            .subscribe(result => {
                this.setState({data: result.data})
            }, error => {

            });
    }
}

export default Home;