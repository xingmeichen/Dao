# React

## Mirror address
### To show default mirror address
npm config get registry
(the original result is https://registry.npmjs.org)

### reset mirror address
npm config set registry {new_registry}
eg.
npm config set registry https://registry.npm.taobao.org

### when cannot install dependency, can try to config proxy
create a .npmrc file (need to confirm where is should place on Mac), and add below content in it
registry={your_registry}
strict-ssl=false

## To create a React project
### create a React project
npx create-react-app {your_project_name}
eg. npx create-react-app my-app
