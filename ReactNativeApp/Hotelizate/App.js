
import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Button
} from 'react-native';
import TextComponent  from './textComponent'
import List from './src/components/List'


export default class App extends Component {

  constructor() {
    super()
    this.state = {
      status: false,
      data: null
    }
  }

  clickPressed() {
    this.setState({
      status: !this.state.status
    })
  }


  render() {
    return (
      <View style={styles.container}>
        <List />
      </View>
    )
  }
}

const styles = StyleSheet.create({

  on: {
    width: 100,
    height: 100,
    backgroundColor: 'green'
  },
  off: {
    width: 100,
    height: 100,
    backgroundColor: 'black'
  },

  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#525252',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

