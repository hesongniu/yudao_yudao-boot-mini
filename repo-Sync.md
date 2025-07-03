git remote add upstream git@github.com:yudaocode/yudao-boot-mini.git

git fetch upstream

git checkout master

git merge upstream/master

git add .

git commit -m "remark"

git push origin master





## 添加子模块
git submodule add git@github.com:hesongniu/yudao_yudao-ui-admin-vue3.git yudao-ui-admin-vue3