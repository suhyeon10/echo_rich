# y | docker image prune -a

aws ecr get-login-password --region ap-northeast-2 --profile tower | docker login --username AWS --password-stdin 427351553050.dkr.ecr.ap-northeast-2.amazonaws.com

docker build -t echo_rich .

docker tag echo_rich:latest 427351553050.dkr.ecr.ap-northeast-2.amazonaws.com/echo_rich:latest

docker push 427351553050.dkr.ecr.ap-northeast-2.amazonaws.com/echo_rich:latest
