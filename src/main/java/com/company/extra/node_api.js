// Constant paramters
const hostname = '127.0.0.1'
const port = 3000

// creating the server
const server = createServer().listen(port)
// const server = createServer()

// // initializing the server
// server.listen(port, hostname, () => {
//     console.log(`Server running at http://${hostname}:${port}/`)
// })


function createServer(){

  const http = require('http')
  const url = require('url')

  const server = http.createServer((req, res) => {

    const reqUrl = url.parse(req.url, true)
    let pathname = reqUrl.pathname
    let endpoint = pathname.substring(0, pathname.indexOf('/',2))
    if(!endpoint.length)
        endpoint = pathname

    const reqParamaters = reqUrl.pathname.split('/')
    reqParamaters.splice(0,2)

    // GET Endpoints
    if(req.method === 'GET'){
        if(endpoint === '/sample'){
            if(reqParamaters.length > 0){
                res.writeHead(200, { 'Content-Type': 'text/plain' })
                res.end(`id sent ${reqParamaters[0]}`)
            }
            else {
                res.writeHead(200, { 'Content-Type': 'text/plain' })
                res.end('response sent')
            }
        }
    }
    else if(req.method === 'POST'){
        if(endpoint === '/sample'){

            let body = '';
            req.on('data', chunk => {
                body += chunk.toString(); // convert Buffer to string
            });
            req.on('end', () => {
                console.log("body", body);
                res.end('ok');
            });
        }
    }
    else{
        sendNotFound(reqUrl, res)
    }

  });
  return server
}

function sendNotFound(reqUrl, res){
    res.writeHead(404, { 'Content-Type': 'text/plain' })
    res.end("end point not found "+reqUrl.pathname)
}

async function getRequests(){
  try{

    console.log("GET called")
    const res = await fetch('http://127.0.0.1:3000/sample/1?name="ayush')
    const resText = await res.text()
    console.log('data received (GET) :', resText);
  }
  catch(e){
    console.log('Exception :' ,e);
  }
}

getRequests()

postRequests()

async function postRequests(){
    try{
        const data = {name: "ayush"}
        const url = 'http://127.0.0.1:3000/sample'
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }

        const response = await fetch(url, options);
        const resText = await response.text()
        console.log('\nReceived respoonse for URL :',url);
        console.log('data received (POST) :', resText);
    }
    catch(e){
        console.error('Error:', e);
    }
}


