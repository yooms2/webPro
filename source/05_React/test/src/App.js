import './App.css';
import React, { Component } from 'react';
import Subject from './components/Subject';
import TOC from './components/TOC';
import ReadContent from './components/ReadContent';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      mode : 'read',
      selected_content_id : 1,
      subject : {title:'WEB', sub:'World wide web!!'},
      welcome : {title:'WELCOME', desc:'Hello, React!'},
      contents : [
        {id:1, title:'HTML', desc:'HTML is HyperText Markup Language.'},
        {id:2, title:'CSS', desc:'CSS is for design'},
        {id:3, title:'JavaScript', desc:'JavaScript is for interactive'},
      ],
    };
  }
  render() {
    console.log('app render', this);
    var _title, _desc = null;
    if(this.state.mode === 'welcome') {
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
    } else if(this.state === 'read') {
      // _title = this.state.contents[0].title;
      // _desc = this.state.contents[0].desc;
      for(var i=0 ; i<this.state.contents.length ; i++) {
        var data = this.state.contents[i];
        if(data.id === this.state.selected_content_id) {
          _title = data.title;
          _desc = data.desc;
          break;
        }
      }
    }
    return (
      <div className="App">
        <Subject title={this.state.subject.title}
          sub={this.state.subject.sub} 
          onChangePage={function() {
            this.setState({
              mode : 'welcome',
            });
          }.bind(this)}>
        </Subject>
        <TOC onChangePage={function(id) {
          this.setState({
            mode:'read',
            selected_content_id : Number(id)

          });
        }.bind(this)}
        data={this.state.contents}></TOC>
        <ReadContent title={_title} desc={_desc}></ReadContent>
      </div>
    );
  }
}

export default App;
